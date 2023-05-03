package com.company.utils;

import com.company.model.Content;
import com.company.model.Producer;
import com.company.model.Song;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

public class FileHandler {

    //classic I/O methods for text



    //using bufferreader
    public static void readFileWithBuffer(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {


                System.out.println(line);
            }
        }
    }

    //using bufferwriter
    public static void writeFileWithBuffer(String fileName, String text, boolean append) throws IOException {
        FileWriter fw = new FileWriter(fileName,append);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(text);
        }
    }


    //new I/O methods for text

    //using readAlllines

    public static void readFileWithReadAllLines(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> lines = Files.readAllLines(file.toPath());
        for(String line : lines) {
            System.out.println(line);
        }
    }

    public static List<Content> readFileSongs(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> lines = Files.readAllLines(file.toPath());
        Content auxSong;
        List<Content> songs = new ArrayList<Content>();
        for(String line : lines) {
            String[] songData = line.split(";");
            String name = songData[0];
            String artist = songData[1];
            String genre = songData[2];
            int duration = Integer.parseInt(songData[3]);
            int year = Integer.parseInt(songData[4]);
            String album = songData[5];


            auxSong = new Song(name,
                    artist,
                    genre,
                    duration,
                    year,
                    album);
            songs.add(auxSong);
        }
        return songs;
    }

    public static Map<Long, Producer> readFileProducers(String fileName) throws IOException,  ClassCastException{
        File file = new File(fileName);
        List<String> lines = Files.readAllLines(file.toPath());
        Producer auxProducer;
        Map<Long, Producer> producers = new HashMap<>();
        for(String line : lines) {
            String[] producerData = line.split(";");
            String name = producerData[0];
            String country = producerData[1];
            String nickName = producerData[2];

            auxProducer = new Producer(name,country,nickName);
            producers.put(
                    auxProducer.getId(),
                    auxProducer);
        }
        return producers;
    }



    //using files.lines

    public static void readFileWithFilesLines(String fileName) throws IOException {
        File file = new File(fileName);
        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.forEach(line -> System.out.println(line));
        }
    }

    //using scanner

    public static void readFileWithScanner(String fileName) throws IOException {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }

    //New I/O reading bytes

    public static void readFileAllBytes(String fileName) throws IOException {
        File file = new File(fileName);

        byte [] fileBytes = Files.readAllBytes(file.toPath());
        char singleChar;
        for(byte b : fileBytes) {
            singleChar = (char) b;
            System.out.print(singleChar);
        }
    }



    //write Song objects to file

    public static void writeSongsToFile(String fileName, List<Content> contents) throws IOException {
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for(Content c : contents) {
                if (c instanceof Song) {
                    oos.writeObject(c);
                }
            }
        }

    }

    public static void writeObjectToFile(String fileName, Object obj) throws IOException {
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obj);
        }

    }

    //read object from file
    public static Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);

        try (FileInputStream fis = new FileInputStream(file);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {

            return ois.readObject();
        }

    }

    public static List<Song> readSongsFromFile (String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        List<Song> songs = new ArrayList<Song>();
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while(true) {
                Song song = (Song) ois.readObject();
                songs.add(song);
                System.out.println(song);
            }
        }catch (EOFException e) {
            return songs;
        }

    }
    
}
