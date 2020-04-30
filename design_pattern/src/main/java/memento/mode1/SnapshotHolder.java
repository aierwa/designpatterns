package memento.mode1;


import java.util.Stack;

/**
 * @author xuxiang
 * 2020/4/30
 */
public class SnapshotHolder {
    private Stack<TextSnapshot> snapshots = new Stack<>();

    public TextSnapshot popSnapshot(){
        return snapshots.pop();
    }
    public void pushSnapshot(TextSnapshot snapshot){
        snapshots.push(snapshot);
    }

}
