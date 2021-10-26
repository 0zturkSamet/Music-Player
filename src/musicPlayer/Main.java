package musicPlayer;

import java.util.*;

public class Main {
    private static ArrayList<Album>albums=new ArrayList<>();
    public static void main(String[] args) {



        Album album=new Album("7 Stunden","Lea");
        album.addSong("110",3.34);
        album.addSong("7 Stunden",2.55);
        album.addSong("TreppenHaus",3.07);
        album.addSong("Zu dir",3.20);
        album.addSong("Drei Uhr Nachts",2.41);
        albums.add(album);


        album=new Album( "Love Again","Dua");

        album.addSong("Love Again",4.23);
        album.addSong("New Rules",3.45);
        album.addSong("We're Good",3.12);
        album.addSong("Zu dir",3.12);
        album.addSong("Rap",3.12);

        albums.add(album);

        LinkedList<Song> playlist_1=new LinkedList<>();
        albums.get(0).addToPlayList("7 Stunden",playlist_1);
        albums.get(0).addToPlayList("TreppenHaus",playlist_1);
        albums.get(1).addToPlayList("Zu dir",playlist_1);
        albums.get(1).addToPlayList("Love Again",playlist_1);
        play(playlist_1);



    }

    private static void play(LinkedList<Song> playlist){
        Scanner sc=new Scanner(System.in);
        boolean quit= false;
        boolean forward=true;
        ListIterator<Song>listIterator=playlist.listIterator();
        if (playlist.size()==0){
            System.out.println("This playlist have no song");
        }else{
            System.out.println("now playing"+ listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action=sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit=true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;

                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing"+listIterator.next().toString());
                    }else{
                        System.out.println("No song avaliable reached to the end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("now playing" + listIterator.previous().toString());
                    }else{
                        System.out.println("we are the first song");
                        forward=false;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing"+listIterator.previous().toString());
                            forward=false;
                        }else{
                            System.out.println("we are at the start of the list");
                        }
                    }else{
                        if (listIterator.hasNext()){
                            System.out.println("now playing"+listIterator.next().toString());
                        }else{
                            System.out.println("we have reached to the end of list");
                        }

                    }
                    break;
                case 4:
                    prinList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("now playing"+listIterator.next().toString());

                        }
                        else{
                            if (listIterator.hasPrevious())
                            System.out.println("now playing"+listIterator.previous().toString());
                        }
                    }



            }
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1- to play next song\n"+
                "2- to play previous song\n"+
                "3- to replay the current song\n"+
                "4- list of all songs\n"+
                "5- print all avaliable options\n"+
                "6- delete current song");
    }

    private static  void prinList(LinkedList<Song>playlist){
        Iterator<Song>iterator=playlist.iterator();
        System.out.println("----------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }
        System.out.println("-----------------------");



    }
}


























