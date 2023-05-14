package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.serializer.StreamSerializer;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStorage extends AbstractStorage<File> {
    private final File dir;
    private final StreamSerializer streamSerializer;

    protected FileStorage(String path, StreamSerializer streamSerializer) {
        Objects.requireNonNull(path, "Directory must not be null");
        dir = new File(path);
        if (!dir.exists() || dir.isFile()) {
            if (!dir.mkdir()) {
                throw new IllegalArgumentException(path + " cannot create this directory");
            }
        }
        if (!dir.canRead() || !dir.canWrite()) {
            throw new IllegalArgumentException(path + " is not readable/writable");
        }
        this.streamSerializer = streamSerializer;
    }

    @Override
    public void clear() {
        getFilesList().forEach(this::doDelete);
    }

    @Override
    public int size() {
        return (int) getFilesList().count();
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
            file.createNewFile();
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

        return getFilesList().map(this::doGet).collect(Collectors.toList());
    }

    private Stream<File> getFilesList() {
        File[] files = dir.listFiles();
        return files == null ? Stream.empty() : Arrays.stream(files);
    }
}