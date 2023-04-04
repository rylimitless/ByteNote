import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class NoteList {
    private ArrayList<Note> notes;
    private Deque<Note> prevNotes;

    public NoteList(){
        notes = new ArrayList<>();
        prevNotes = new LinkedList<>();
    }

    public void addNote(Note note){
        notes.add(note);
        prevNotes.push(note);
    }

    public void removeNote(Note note){
        notes.remove(note);
    }

    public void addPrevNotes(Note note){
        prevNotes.add(note);
    }

    public Note getTopNote(){
        return prevNotes.getFirst();
    }

}
