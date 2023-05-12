package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private final File dir;
    private StreamSerializer streamSerializer;

    protected FileStorage(String path, StreamSerializer streamSerializer) {
        Objects.requireNonNull(path, "Directory must not be null");
        dir = new File(path);
        if(!dir.exists() || dir.isFile()){
            if(!dir.mkdir()){
                throw new IllegalArgumentException(path + " cannot create this directory");
            };
        }
        if (!dir.canRead() || !dir.canWrite()) {
            throw new IllegalArgumentException(path + " is not readable/writable");
        }
        this.streamSerializer = streamSerializer;
    }

    @Override
    public void clear() {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                doDelete(file);
            }
        }
    }

    @Override
    public int size() {
        String[] list = dir.list();
        if (list == null) {
            throw new StorageException("Directory read error", null);
        }
        return list.length;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(dir, uuid);
    }

    @Override
    protected void doUpdate(File file, Resume resume) {
        try {
            streamSerializer.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", resume.getUuid());
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(File file, Resume resume) {
        try {
            if (!file.createNewFile()) {
                throw new StorageException("Couldn't create file: file " + file.getAbsolutePath() +
                        " already exists", resume.getUuid());

            }
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), resume.getUuid());
        }
        doUpdate(file, resume);
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName());
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = dir.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error", null);
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(doGet(file));
        }
        return list;
    }
}