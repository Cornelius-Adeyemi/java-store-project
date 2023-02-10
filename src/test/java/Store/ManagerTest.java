package Store;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest{





    @Test
    @DisplayName("Testing the employ method and the getCurrent manager method ")
    void employManager() {
        String name = "Adebisi";
        Manager.employManager(name);
        Manager manager = (Manager) Manager.getCurretManager();
        assertEquals(name,manager.name);
    }



    @Test
    @DisplayName("testing the sack manager method")
    void sackCurrentManager() {
        String name = "Adebisi";
        Manager.employManager(name);
        String result1 =Manager.sackCurrentManager();
        String result = (String) Manager.getCurretManager();
        assertEquals("The store has no manager at the moment",result);
        assertEquals("You've successfully sacked the current manager",result1);
    }
}