package com.company;

import com.company.model.Content;
import com.company.model.Podcast;
import com.company.model.Producer;
import com.company.model.Song;
import com.company.utils.FileHandler;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {



        //Lists can not be created with the following syntax
        // as they are abstract classes

        //List number = new List();

        //But we can create an instance of a List
        // of a concrete class
        List<Content> contentDb = new ArrayList<Content>();
        try{
            contentDb  = FileHandler.readFileSongs("src/com/company/resources/Songs.csv");
        }catch (IOException e){
            System.out.println("Error reading file");

        }catch (ClassCastException e){
            System.out.println("Error casting file");
        }


        Map<Long, Producer> producersDb = new HashMap<Long, Producer>();

        try{
            producersDb = FileHandler.readFileProducers("src/com/company/resources/Producers.csv");

        }catch (IOException e){
            System.out.println("Error reading file");

        }catch (ClassCastException e){
            System.out.println("Error casting file");
        }


        try {
            FileHandler.writeSongsToFile("DB_Songs.dat",contentDb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Reading the songs from the file
        try {
            List<Song> songsFromFile = FileHandler.readSongsFromFile("DB_Songs.dat");
            System.out.println(songsFromFile);
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        //Writing list directly to a file
        try {
            FileHandler.writeObjectToFile("DB_Songs.dat",contentDb);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Reading list directly from a file
        try {
            List<Content> songsFromFile =(ArrayList<Content>) FileHandler.readObjectFromFile("DB_Songs.dat");
        }  catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        addNewSongToDb(contentDb, producersDb);

        //Printing the songs
        for (Content c : contentDb) {

            if (c instanceof Song) {
                System.out.println(c);
            }

        }

    }

    public static void addNewSongToDb(List<Content> contentDb, Map<Long,Producer> producersDb){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to add song or podcast? (s/p)");
        String option = scanner.nextLine();

        if(option.equals("s")){
            System.out.println("Enter song name");
            String songName = scanner.nextLine();
            System.out.println("Enter song Artist");
            String songArtist = scanner.nextLine();
            System.out.println("Enter song genre");
            String songGenre = scanner.nextLine();
            System.out.println("Enter song duration");
            Integer songDuration = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter song year");
            Integer songYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter song Album");
            String songAlbum = scanner.nextLine();


            Song song = new Song(songName, songArtist, songGenre, songDuration, songYear, songAlbum);


            String answer;
            do {
                System.out.println("Please type Producer ID");
                Long producerId = Long.parseLong(scanner.nextLine());
                if (producersDb.containsKey(producerId)) {
                    song.addProducer(producersDb.get(producerId));
                    System.out.println("would you like to add another producer? (y/n)");
                    answer = scanner.nextLine();

                } else {
                    System.out.println("Producer not found");
                    answer = "y";
                }

            } while (answer.equalsIgnoreCase("y"));

            contentDb.add(song);
            System.out.println("Song added to DB");
        }
        else if(option.equals("p")){
            System.out.println("Enter podcast name");
            String podcastName = scanner.nextLine();
            System.out.println("Enter podcast author");
            String podcastAuthor = scanner.nextLine();
            System.out.println("Enter podcast category");
            String podcastCategory = scanner.nextLine();
            System.out.println("Enter podcast duration");
            Integer podcastDuration = Integer.parseInt(scanner.nextLine());


            Podcast podcast = new Podcast(podcastName, podcastDuration, podcastCategory, podcastCategory);
            
            
        }

    }

    private static void addProducersToContent(Content content, Map<Long, Producer> producersDb, List<Content> contentDb) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Please type Producer ID");
            Long producerId = Long.parseLong(scanner.nextLine());
            if (producersDb.containsKey(producerId)) {
                content.addProducer(producersDb.get(producerId));
                System.out.println("would you like to add another producer? (y/n)");
                answer = scanner.nextLine();

            } else {
                System.out.println("Producer not found");
                answer = "y";
            }

        } while (answer.equalsIgnoreCase("y"));

        contentDb.add(content);
        System.out.println("Song added to DB");
    }

    private static void linkContentToProducer(Content content, Map<Long, Producer> producersDb) {

        Set<Producer> auxProducers = content.getProducers();
        for (Producer producer : auxProducers) {
            producersDb.get(producer.getId()).addContent(content);
        }

    }


}
