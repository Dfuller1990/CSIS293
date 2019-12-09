package edu.gcccd.csis;

import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FinderTest {

    @SuppressWarnings({"unchecked"})
    private static File findExtremeFile(final Path p) {
        final List<File> fileList = new ArrayList<>();
        fileList.add(p.toFile());
        File x = null;

        while (!fileList.isEmpty()){
            File f = fileList.remove(0);
            if (f.isFile()){
                x= edu.gcccd.csis.Finder.extreme(x,f);
            }else if (f.isDirectory()){
                fileList.add(x);
            }
        }
        return x;
    }

    @Test
    public void testExtreme() throws Exception {
        // check what happens if one file is null ..
        File f1 = null;
        final File f2 = File.createTempFile("test2_", ".tmp");
        f2.deleteOnExit();

        assertEquals(f2, Finder.extreme(f1, f2));
        assertEquals(f2, Finder.extreme(f2, f1));
        assertEquals(f2, Finder.extreme(f2, f1));
        assertEquals(f2, Finder.extreme(f1, f2));
    }

    @Test
    public void findExtremeFile() throws Exception {
        final File f2 = File.createTempFile("test", ".tmp");
        f2.deleteOnExit();
        final Path p = f2.getParentFile().getParentFile().toPath();
        final File extreme1 = Finder.findExtremeFile(p);
        final File extreme2 = FinderTest.findExtremeFile(p);
        assertEquals(extreme1, extreme2);
    }
}