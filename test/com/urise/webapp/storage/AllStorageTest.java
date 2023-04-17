package com.urise.webapp.storage;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ListStorage.class, ArrayStorageTest.class, SortedArrayStorageTest.class,
        MapResumeStorageTest.class, MapUUIDStorageTest.class})
public class AllStorageTest {}
