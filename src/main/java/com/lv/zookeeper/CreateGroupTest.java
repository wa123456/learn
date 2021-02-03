package com.lv.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CreateGroupTest {
    private static String hosts = "117.50.9.63";
    private static String groupName = "zoo1";

    private CreateGroup createGroup = null;

    /**
     * init
     * @throws InterruptedException
     * @throws KeeperException
     * @throws IOException
     */
    @Before
    public void init() throws KeeperException, InterruptedException, IOException {
        createGroup = new CreateGroup();
        createGroup.connect(hosts);
    }

    @Test
    public void testCreateGroup() throws KeeperException, InterruptedException {
        createGroup.create(groupName);
    }

    /**
     * 销毁资源
     */
    @After
    public void destroy() {
        try {
            createGroup.close();
            createGroup = null;
            System.gc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
