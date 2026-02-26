package com.example.coffee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for KoolaidType enum.
 * Ensures all Koolaid flavors are properly defined and implement BeverageType interface correctly.
 */
class KoolaidTypeTest {

    @Test
    void testKoolaidTypeValues() {
        KoolaidType[] types = KoolaidType.values();
        assertEquals(4, types.length, "Should have exactly 4 Koolaid flavors");
        
        assertEquals(KoolaidType.PEACH, types[0]);
        assertEquals(KoolaidType.KIWI, types[1]);
        assertEquals(KoolaidType.FRUIT_PUNCH, types[2]);
        assertEquals(KoolaidType.RASPBERRY, types[3]);
    }

    @Test
    void testKoolaidTypeDisplayNames() {
        assertEquals("Peach", KoolaidType.PEACH.getDisplayName());
        assertEquals("Kiwi", KoolaidType.KIWI.getDisplayName());
        assertEquals("Fruit Punch", KoolaidType.FRUIT_PUNCH.getDisplayName());
        assertEquals("Raspberry", KoolaidType.RASPBERRY.getDisplayName());
    }

    @Test
    void testKoolaidTypeToString() {
        assertEquals("Peach", KoolaidType.PEACH.toString());
        assertEquals("Kiwi", KoolaidType.KIWI.toString());
        assertEquals("Fruit Punch", KoolaidType.FRUIT_PUNCH.toString());
        assertEquals("Raspberry", KoolaidType.RASPBERRY.toString());
    }

    @Test
    void testKoolaidTypeImplementsBeverageType() {
        assertTrue(KoolaidType.PEACH instanceof BeverageType);
        assertTrue(KoolaidType.KIWI instanceof BeverageType);
        assertTrue(KoolaidType.FRUIT_PUNCH instanceof BeverageType);
        assertTrue(KoolaidType.RASPBERRY instanceof BeverageType);
    }

    @Test
    void testKoolaidTypeValueOf() {
        assertEquals(KoolaidType.PEACH, KoolaidType.valueOf("PEACH"));
        assertEquals(KoolaidType.KIWI, KoolaidType.valueOf("KIWI"));
        assertEquals(KoolaidType.FRUIT_PUNCH, KoolaidType.valueOf("FRUIT_PUNCH"));
        assertEquals(KoolaidType.RASPBERRY, KoolaidType.valueOf("RASPBERRY"));
    }

    @Test
    void testKoolaidTypeValueOfThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            KoolaidType.valueOf("INVALID");
        });
    }

    @Test
    void testKoolaidTypeEnumConstantExists() {
        assertNotNull(KoolaidType.PEACH);
        assertNotNull(KoolaidType.KIWI);
        assertNotNull(KoolaidType.FRUIT_PUNCH);
        assertNotNull(KoolaidType.RASPBERRY);
    }

    @Test
    void testKoolaidTypeEquality() {
        assertEquals(KoolaidType.PEACH, KoolaidType.valueOf("PEACH"));
        assertNotEquals(KoolaidType.PEACH, KoolaidType.KIWI);
        assertNotEquals(KoolaidType.FRUIT_PUNCH, KoolaidType.RASPBERRY);
    }

    @Test
    void testKoolaidTypeHashCode() {
        assertEquals(KoolaidType.PEACH.hashCode(), KoolaidType.PEACH.hashCode());
        assertEquals(KoolaidType.KIWI.hashCode(), KoolaidType.valueOf("KIWI").hashCode());
    }

    @Test
    void testAllKoolaidTypesHaveUniqueDisplayNames() {
        KoolaidType[] types = KoolaidType.values();
        assertEquals(4, java.util.Arrays.stream(types)
                .map(KoolaidType::getDisplayName)
                .distinct()
                .count());
    }
}
