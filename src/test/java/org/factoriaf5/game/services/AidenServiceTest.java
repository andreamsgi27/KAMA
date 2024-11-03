package org.factoriaf5.game.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AidenServiceTest {
    
    private AidenService aidenService;

    @BeforeEach
    void setUp() {
        aidenService = new AidenService();
        // Set initial health for Aiden, assuming there's a way to set it
        aidenService.setaidenHealth(100);
    }

    @Test
    void testReceiveDamage() {
        aidenService.receiveDamage(20);
        assertEquals(80, aidenService.getaidenHealth());
    }

    @Test
    void testPowerStrike() {
        aidenService.powerStrike();
        // Assuming aidenDamage can be accessed or tested through a getter
        assertEquals(10, aidenService.getaidenDamage()); // Adjust as needed
    }

    @Test
    void testShield() {
        // Mocking Monster behavior if necessary
        int reducedAttack = aidenService.shield();
        assertEquals(0, reducedAttack); // Assuming monsterAttack was initially less than or equal to 5
    }

    @Test
    void testIncrementHealth() {
        aidenService.incrementHealth(20);
        assertEquals(120, aidenService.getaidenHealth());
    }

    @Test
    void testAidenIsAlive() {
        assertTrue(aidenService.aidenisAlive());
        aidenService.receiveDamage(100);
        assertFalse(aidenService.aidenisAlive());
    }

    @Test
    void testAidenDie() {
        aidenService.receiveDamage(100);
        // Assuming you can capture printed output, otherwise adjust the logic
        aidenService.aidenDie();
        // Verify printed output, if needed, using system output capturing
    }

    @Test
    void testStat() {
        String stats = aidenService.stat();
        assertTrue(stats.contains("Estadísticas de la partida:"));
        // Add more assertions based on expected values
    }
}
