package fr.mla.customer.feed.uuid;

import java.util.UUID;

/**
 * Utility class designed to provide UUIDs (for the CUST table primary key)<br/>
 * UUIDs look like this: <code>be88c70d-4d62-456b-abd8-d36754e7d970</code>
 */
public class UUIDGenerator {

    private UUIDGenerator() {}

    /**
     * A shortcut for <code>generate().toString()</code>
     * @return A freshly generated brand new UUID (as String)
     */
    public static String generateAsString() {
        return UUID.randomUUID().toString();
    }

    /**
     * Randomly generates a UUID (version 4 - Variant 2)
     * @return A freshly generated brand new UUID
     */
    public static UUID generate() {
        return UUID.randomUUID();
    }


}
