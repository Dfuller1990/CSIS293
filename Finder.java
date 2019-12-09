package edu.gcccd.csis;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//Finds the largest file using DFS.
class Finder {

    public static void main(final String[] args) {
        List<Path> list = new ArrayList<>();
        final Path path = Paths.get(args.length < 1 ? "C:\\" : args[0]);
        final File ex = findExtremeFile(path);
        System.out.printf("Starting at : %s, the largest file was found here:\n%s\n its size is: %d\n",
                path.toAbsolutePath().toString(),
                ex.getAbsolutePath(),
                ex.length());
    }

    static File extreme(final File f1, final File f2) {
        if (f2 == null) return f1;
        if (f1 == null) return f2;
        return f1.getAbsolutePath().length() > f2.getAbsolutePath().length() ? f1 : f2;
    }

    static File findExtremeFile(final Path p) {
        File x = null;
        final File[] fa = p.toFile().listFiles();
        if (fa != null && 0<fa.length) { // if null then directory is probably not accessible
            for(final File f : fa){
                if (f.isFile()) {
                    x = extreme(x, f);
                } else if (f.isDirectory()){
                    x = extreme(x,findExtremeFile(f.toPath()));
                }
            }
        }
        return x;
    }
}
