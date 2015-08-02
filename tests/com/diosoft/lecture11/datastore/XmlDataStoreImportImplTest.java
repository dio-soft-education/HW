package com.diosoft.lecture11.datastore;

import org.junit.Test;

public class XmlDataStoreImportImplTest {

    @Test
    public void testImportDataStore() throws Exception {
        DataStore dataStore = new CalendarDataStoreImpl("D:\\Projects\\HW\\src\\com\\diosoft\\lecture11\\events.db");
        DataStoreImport importData = new XmlDataStoreImportImpl(dataStore);
        importData.importDataStore("D:\\Projects\\HW\\src\\com\\diosoft\\lecture11\\export\\xml.zip");
    }
}