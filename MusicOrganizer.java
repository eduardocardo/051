import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;

/**
 * A class to hold details of audio tracks.
 * Individual tracks may be played.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing music tracks.
    private ArrayList<Track> tracks;
    // A player for the music tracks.
    private MusicPlayer player;
    // A reader that can read music files and load them as tracks.
    private TrackReader reader;
    
    
    

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer(String file)
    {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary(file);
        
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
        System.out.println();
    }
    
    /**
     * Add a track file to the collection.
     * @param filename The file name of the track to be added.
     */
    public void addFile(String filename)
    {
        tracks.add(new Track(filename));
    }
    
    /**
     * Add a track to the collection.
     * @param track The track to be added.
     */
    public void addTrack(Track track)
    {
        tracks.add(track);
    }
    
    /**
     * Play a track in the collection.
     * @param index The index of the track to be played.
     */
    public void playTrack(int index)
    {
        if(indexValid(index) && (player.isPlaying()==false)) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            track.addPlayCount();
            
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
        }
        else if(player.isPlaying())
        {
            System.out.println("Ya hay una reproduccion en curso");
        }
    }
    
    /**
     * Return the number of tracks in the collection.
     * @return The number of tracks in the collection.
     */
    public int getNumberOfTracks()
    {
        return tracks.size();
    }
    
    /**
     * List a track from the collection.
     * @param index The index of the track to be listed.
     */
    public void listTrack(int index)
    {
        System.out.print("Track " + index + ": ");
        Track track = tracks.get(index);
        System.out.println(track.getDetails());
    }
    
    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks()
    {
        System.out.println("Track listing: ");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }
    
    /**
     * List all tracks by the given artist.
     * @param artist The artist's name.
     */
    public void listByArtist(String artist)
    {
        for(Track track : tracks) {
            if(track.getArtist().contains(artist)) {
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * Remove a track from the collection.
     * @param index The index of the track to be removed.
     */
    public void removeTrack(int index)
    {
        if(indexValid(index)) {
            tracks.remove(index);
        }
    }
    
    /**
     * Play the first track in the collection, if there is one.
     */
    public void playFirst()
    {
        Track track = tracks.get(0);
        if(tracks.size() > 0 && (player.isPlaying()==false)) 
        {
            player.startPlaying(tracks.get(0).getFilename());
            track.addPlayCount();
           
        }
        else if(player.isPlaying())
        {
            System.out.println("Ya hay una reproduccion en curso");
        }
    }
    
    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
        
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= tracks.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    private void readLibrary(String folderName)
    {
        ArrayList<Track> tempTracks = reader.readTracks(folderName, ".mp3");

        // Put all thetracks into the organizer.
        for(Track track : tempTracks) {
            addTrack(track);
        }
    }
    
    /**
     * Metodo que muestre por pantalla la informaci�n de los tracks que contienen
     * una cadena en el t�tulo de la canci�n.
     */
    public  void findInTitle(String tempTrack)
    {
        
        for(Track track : tracks )
        {
            if(track.getTitle().contains(tempTrack))
            {
                System.out.println(track.getDetails());
            }
        }
    }
    
    /**
     * Metodo que modifica el atributo language en un determinado track
     */
    public void setLanguageOfTrack(int index,String language)
    {
        Track track = tracks.get(index);
        track.setLanguage(language);
    }
    
    /**
     * Metodo que indica por pantalla si en ese momento se esta reproduciendo una cancion
     */
    public void isPlaying()
    {
        if(player.isPlaying())
        {
            System.out.println("En este momento se esta reproduciendo una cancion");
        }
        else
        {
            System.out.println("En este momento no se esta reproduciendo una cancion");
        }
    }
    
    /**
     * Metodo que muestra los detalles de todos los tracks almacenados en un organizador usando un iterador.
     */
    public void listAllTrackWithIterator()
    {
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext())
        {
            Track track = it.next();
            System.out.println(track.getDetails());
        }
    }
    
     /**
     * Metodo que permite eliminar del organizador tracks que contengan un determinado artista usando un iterador
     */
    public void removeByArtist(String artist)
    {
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext())
        {
            Track track = it.next();
            if(track.getArtist().contains(artist))
            {
                it.remove();
            }
        }
    }
    
        /**
     * Metodo que permite eliminar del organizador tracks que contengan 
     * una determinada cadena en el t�tulo de la canci�n usando un iterador.
     */
    public void removeByTitle(String title)
    {
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext())
        {
            Track track = it.next();
            if(track.getTitle().contains(title))
            {
                it.remove();
            }
        }
    }
    
    /**
     * Metodo que reproduzca una de las canciones del organizador al azar
     */
    public void playRandom()
    {
        Random rnd = new Random();
        int index = rnd.nextInt(tracks.size());
        playTrack(index);
    }
    
    /**
     * Metodo  que permita reproducir los primeros segundos de cada canci�n en orden aleatorio 
     */
    public void playShuffle()
    {
        
        Collections.shuffle(tracks);
        Iterator<Track> it = tracks.iterator();
        while(it.hasNext())
        {
            Track track = it.next();
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            player.playSample(track.getFilename());
            track.addPlayCount();
            
        }
    }
    
    /**
     * Metodo que permite seleccionar aleatoriamente de la copia una cancion,reproducirla y luego eliminarla
     */
    public void playShuffle2()
    {
        //Se hace la copia del ArrayList
        ArrayList<Track> copia = new ArrayList<>();
        copia = (ArrayList)tracks.clone();
        //Se selecciona aleatoriamente una cancion para reproducir
        Collections.shuffle(copia);
        Iterator<Track> it = copia.iterator();
        while(it.hasNext())
        {
            Track track = it.next();
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            player.playSample(track.getFilename());
            track.addPlayCount();
            //se elimina la cancion
            it.remove();
        }
        
    }
}
