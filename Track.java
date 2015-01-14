/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    //almacena el numero de  veces que se ha reproducido una canci�n.
    private  int playCount;
    //indica el idioma en el que esta la cancion
    private String language;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename,String language)
    {
        setDetails(artist, title, filename,language);
        playCount = 0;
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename,"unknown");
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + "  (file: " + filename + ")" + " " + "Language : " + language + " "  + "Playcount : " + playCount;
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String filename,String language)
    {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
        this.language = language;
    }
    
    /**
     * Metodo que resetea el contador de reproduciones de un track a 0
     */
    public void resetPlayCount()
    {
        playCount = 0;
    }
    
    /**
     * Metodo que aumenta el contado de reproduciones de un track en una unidad
     */
    public void addPlayCount()
    {
        playCount++;
    }
    
    /**
    * Metodo que devuelve el idioma en el que esta una cancion
    */
    public String getLanguage()
    {
        return language;
    }
     
    /**
    * Metodo que modifica el  atributo language
    */
    public void setLanguage(String language)
    {
        this.language = language;
    }
}
