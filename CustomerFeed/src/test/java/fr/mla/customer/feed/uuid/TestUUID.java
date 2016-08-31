package fr.mla.customer.feed.uuid;

import org.testng.annotations.Test;

import java.util.UUID;

public class TestUUID {

    @Test(enabled = true)
    public void acceptUuidGeneratorAsString() {
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.println(UUIDGenerator.generateAsString());
        }

        System.out.println("-------------------------------------------------");

    }

    @Test(enabled = true)
    public void acceptUuidGenerator() {
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            UUID uuid = UUIDGenerator.generate();
            System.out.println(uuid.toString() + "\tVersion " + uuid.version() + "\tVariant " + uuid.variant());
        }

        System.out.println("-------------------------------------------------");

    }

}
