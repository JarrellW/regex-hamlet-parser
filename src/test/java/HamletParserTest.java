import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String parse = hamletParser.ChangeHamletToLeon(hamletText);
        Assert.assertFalse(hamletParser.findHamlet(parse));

    }

    @Test
    public void testChangeHoratioToTariq() {
        String parse = hamletParser.ChangeHoratioToTariq(hamletText);
        Assert.assertFalse(hamletParser.findHoratio(parse));
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio(hamletText));
        Assert.assertFalse(hamletParser.findHoratio("Tariq owes me money"));
        Assert.assertTrue(hamletParser.findHamlet("Horatio"));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet(hamletText));
        Assert.assertFalse(hamletParser.findHamlet("Leon died is this story"));
        Assert.assertTrue(hamletParser.findHamlet("Hamlet"));
    }
}