package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.TestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import sixdegrees.KevinBaconNumber;

public class Tests {

    @Test
    public void testPath1() {
        String filename = "data/test1.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String from = "Bacon, Kevin";
            String to = "Diaz, Cameron";
            int pathLength = kv.path(from, to) / 2;
            assertEquals(pathLength, 2);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testPath2() {
        String filename = "data/cast.06.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String from = "Jolie, Angelina";
            String to = "Farmiga, Vera";
            int pathLength = kv.path(from, to) / 2;
            assertEquals(pathLength, 2);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testPath3() {
        String filename = "data/cast.all.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String from = "Pacino, Al";
            String to = "Bacon, Kevin";
            int pathLength = kv.path(from, to) / 2;
            assertEquals(pathLength, 1);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testPath4() {
        String filename = "data/action06.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String from = "Pacino, Al";
            String to = "Bacon, Kevin";
            int pathLength = kv.path(from, to) / 2;
            assertEquals(pathLength, 3);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testPath5() {
        String filename = "data/test1.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String from = "Myers, Mike";
            String to = "Campbell, Neve";
            int pathLength = kv.path(from, to) / 2;
            assertEquals(pathLength, 1);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testCast1() {
        String filename = "data/test1.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String s = kv.neighbors("Murray, Bill");
            String answer = "[Charlie's Angels (1900)],[Wild Things (1900)],";
            assertEquals(s, answer);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testCast2() {
        String filename = "data/test1.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String s = kv.neighbors("Shrek (1900)");
            String answer = "[Diaz, Cameron],[Lithgow, John],[Myers, Mike],";
            assertEquals(s, answer);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testCast3() {
        String filename = "data/test1.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String s = kv.neighbors("Wild Things (1900)");
            String answer = "[Bacon, Kevin],[Campbell, Neve],[Murray, Bill],";
            assertEquals(s, answer);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testMovies1() {
        String filename = "data/cast.06.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String s = kv.neighbors("Damon, Matt");
            String answer = "[Departed, The (2006)],[Good Shepherd, The (2006)],";
            assertEquals(s, answer);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testMoviesAll() {
        String filename = "data/cast.all.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String s = kv.neighbors("Damon, Matt");
            // System.out.println(s);
            String answer = "[All the Pretty Horses (2000)],[Bourne Identity, The (2002)],[Bourne Supremacy, The (2004)],[Bourne Ultimatum, The (2007)],[Brothers Grimm, The (2005)],[Chasing Amy (1997)],[Confessions of a Dangerous Mind (2002)],[Courage Under Fire (1996)],[Departed, The (2006)],[Dogma (1999)],[EuroTrip (2004)],[Field of Dreams (1989)],[Fighter, The (2009)],[Finding Forrester (2000)],[Fremde (1999)],[Geronimo: An American Legend (1993)],[Gerry (2002)],[Glory Daze (1996)],[Good Mother, The (1988)],[Good Shepherd, The (2006)],[Good Will Hunting (1997)],[Howard Zinn: You Can't Be Neutral on a Moving Train (2004)],[Jay and Silent Bob Strike Back (2001)],[Jersey Girl (2004)],[Legend of Bagger Vance, The (2000)],[Magnificent Desolation: Walking on the Moon 3D (2005)],[Majestic, The (2001)],[Margaret (2007)],[Mystic Pizza (1988)],[Ocean's Eleven (2001)],[Ocean's Thirteen (2007)],[Ocean's Twelve (2004)],[Rainmaker, The (1997)],[Rounders (1998)],[Running the Sahara (2007)],[Saving Private Ryan (1998)],[School Ties (1992)],[Spirit: Stallion of the Cimarron (2002)],[Stuck on You (2003)],[Syriana (2005)],[Talented Mr. Ripley, The (1999)],[Third Wheel, The (2002)],[Titan A.E. (2000)],[Untitled Ben Affleck Matt Damon Project (2007)],[Youth Without Youth (2007)],";
            assertEquals(s, answer);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    @Test
    public void testCast5() {
        String filename = "data/cast.G.txt";
        String delimiter = "/";
        KevinBaconNumber kv;
        try {
            kv = new KevinBaconNumber(filename, delimiter);
            String s = kv.neighbors("Charlotte's Web (2006)");
            String answer = "[Anderson, Kevin (I)],[Arthur, Robyn],[Basaraba, Gary],[Bates, Kathy (I)],[Bell, Nicholas],[Benjamin, André],[Benrubi, Abraham],[Bridges, Beau],[Bridges, Don (I)],[Buscemi, Steve],[Cedric the Entertainer],[Church, Thomas Haden],[Cleese, John],[Corbett, Louis],[Davis, Essie],[Fallon, Siobhan],[Fanning, Dakota],[Hodge, Briana],[Kay, Dominic Scott],[Kirby, Denise],[Kirkpatrick, Maia],[Lotesto, Joseph],[McCrary, Joel (I)],[McEntire, Reba],[Mooney, Nate],[O'Donnell, Julian],[Plazek, Robert],[Redford, Robert (I)],[Roberts, Julia (I)],[Roland, Michael],[Rook, Teague],[Rose, Jennessa],[Shepard, Sam],[Stepanek, Brian],[Tatasciore, Fred],[Watkin, Ian],[White, Bradley (I)],[Winfrey, Oprah],[Zemiro, Julia],";
            assertEquals(s, answer);
        } catch (FileNotFoundException ex) {
            System.err.println("Input File Not Found.");
        } catch (IOException ex) {
            System.err.println("Input File Read Error.");
        }
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.getTestHeader() + ":" + failure.getTrace());
        }
    }
}
