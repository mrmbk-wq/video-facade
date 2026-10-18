package client;

import facade.VideoConversionException;
import facade.VideoConversionFacade;
import subsystem.BitrateReader;
import subsystem.CodecFactory;
import subsystem.VideoFile;

public class Main {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();

        System.out.println("=== 1. Normal client: facade only ===");
        try {
            System.out.println("Result: " + converter.convert("holiday.mp4", "ogg"));
        } catch (VideoConversionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== 2. Error handling: unsupported format ===");
        try {
            converter.convert("holiday.mp4", "avi");
        } catch (VideoConversionException e) {
            System.out.println("Error: " + e.getMessage() + " -> " + e.getCause().getMessage());
        }

        System.out.println("\n=== 3. Advanced client bypasses the facade ===");
        CodecFactory factory = new CodecFactory();
        var codec = factory.forFormat("mkv");
        byte[] raw = new BitrateReader().read(new VideoFile("clip.mkv", "mkv"), codec);
        System.out.println("Raw frames read directly: " + raw.length + " bytes");
    }
}
