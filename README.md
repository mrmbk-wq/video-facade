# Video Conversion Facade (Java 17)

Assignment #4 — Facade Pattern, ShP-2216 Software Design Patterns.

## Structure
- `src/subsystem` — CodecFactory, Codec (+ Mpeg4/Ogg/H264), BitrateReader, AudioMixer, VideoFile
- `src/facade` — VideoConversionFacade, VideoConversionException
- `src/client` — Main (demo)

## Run
```
javac -d out $(find src -name "*.java")
java -cp out client.Main
```

## Idea
The client calls only `convert(filename, format)`. The facade picks codecs, reads, re-encodes and normalizes audio in the correct order. Subsystem classes do not know the facade exists and can still be used directly (see demo part 3).
