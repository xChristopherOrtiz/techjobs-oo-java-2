package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;
public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testJobsForEquality() {
        // Generate two Job objects that have identical field values EXCEPT for id
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Test that equals returns false
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testSettingJobId() {
        // Create two Job objects using the empty constructor
        Job job1 = new Job();
        Job job2 = new Job();

        // Use assertNotEquals to verify that the IDs of the two objects are distinct
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        // Declare and initialize a new Job object with the specified data
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // Use assertTrue and assertEquals statements to test that the constructor correctly assigns both
        // the class and value of each field.

        // Check the name field
        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        // Check the employer field
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        // Check the location field
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        // Check the positionType field
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        // Check the coreCompetency field
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());

        // Check the id field
        assertTrue(job.getId() >= 0);
    }
}
