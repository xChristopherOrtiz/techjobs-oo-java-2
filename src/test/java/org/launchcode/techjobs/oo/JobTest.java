package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job job = new Job();

        String jobString = job.toString();

        // Check that the string starts and ends with a new line
        assertTrue(jobString.startsWith(System.lineSeparator()));
        assertTrue(jobString.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();
        assertTrue(jobString.contains("ID:"));
        assertTrue(jobString.contains("Name: Product tester"));
        assertTrue(jobString.contains("Employer: ACME"));
        assertTrue(jobString.contains("Location: Desert"));
        assertTrue(jobString.contains("Position Type: Quality control"));
        assertTrue(jobString.contains("Core Competency: Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = job.toString();
        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }

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
