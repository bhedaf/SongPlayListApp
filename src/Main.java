import javax.swing.*;
import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("Album1", "One Direction");
        album.addSong("Drag me down", 3.56);
        album.addSong("Night Changes", 2.59);
        album.addSong("Steal my Girl", 2.46);
        albums.add(album);

        album = new Album("Album2", "Niall Horan");
        album.addSong("Still", 3);
        album.addSong("This Town", 4.05);
        album.addSong("Everywhere", 5.69);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addTOPlayList("Still", playList_1);
        albums.get(0).addTOPlayList("Everywhere", playList_1);
        albums.get(1).addTOPlayList("Steal my Girl", playList_1);
        albums.get(1).addTOPlayList("Night Changes", playList_1);

        play(playList_1);

    }

    private static void play (LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            printMenu();
            System.out.println("This Playlist has no song!");
        }
        else{
            System.out.println("Now PLaying: "+listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now PLaying: "+ listIterator.next().toString());
                    }else{
                        System.out.println("NO song availble, end of list");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing: "+ listIterator.previous().toString());
                    }else{
                        System.out.println("we are at the first song!");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("NOw playing" + listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("we are at the start of list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }
                        else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing " +listIterator.next().toString());
                           // forward = true;
                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("now playing" + listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available Option\n press");
        System.out.println("0- to quit\n" +
                "1- to play nec=xt song\n" +
                "2- to play previous song\n"+
                "3- to replay the current song\n" +
                "4- to get list of all songs"+
                "5- print all available options\n"+
                "6- delete current song");
    }

    private static void printList(LinkedList<Song> playList){

        Iterator<Song> iterator = playList.iterator();
        System.out.println("---------------------------------");
        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------");
    }
}
























