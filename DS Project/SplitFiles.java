import java.io.*;
public class SplitFiles {
    public static void main(String[] args) throws IOException {
        // Check command−line parameter usage
        if (args.length != 1) {
            System.out.println("Usage: java SplitFiles sourceFile");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }
        // Check if target file exists
        //File targetFile = new File(args[1]);
        //if (targetFile.exists()) {
        //    System.out.println("Target file " + args[1] + " already exists");
        //    System.exit(3);
        //}
        final long size = 10 * 1024 * 1024;

        try (
                // Create an input stream
                BufferedInputStream input =
                        new BufferedInputStream(new FileInputStream(sourceFile));
        ) {

            int splitFileNumber = (int) (sourceFile.length() / size) + 1 ;

            String splitFile = args[0].substring(0, args[0].indexOf('.'));

            for (int i = 1 ; i <= splitFileNumber; i++) {
                int r, numberOfBytesCopied = 0;
                String targetFile = splitFile + "." + String.format("%03d", i);
                try (
                        // Create an output stream
                        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
                ) {
                    // Continuously read a byte from input and write it to output
                    while ((r = input.read()) != -1 && numberOfBytesCopied != size) {
                        output.write((byte)r);
                        numberOfBytesCopied++;
                    }
                }
                System.out.println(targetFile + " file created. (" + (int)numberOfBytesCopied / (1024 * 1024) + "MB)");
            }
            // Display the file size
            System.out.println(sourceFile + " file is split into " + splitFileNumber + " files");
        }
    }
}
