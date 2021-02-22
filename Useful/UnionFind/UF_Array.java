package UnionFind;

/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Union Find implementation using an Array
 ******************************************************************************/

public class UF_Array {
    private int parent[], size[];

    public UF_Array(int capacity) {
        parent = new int[capacity];
        for (int i = 0; i < capacity; i++)
            parent[i] = i;
        size = new int[capacity];
        for (int i = 0; i < capacity; i++)
            size[i] = 1;
    }

    //O(log n)
    public int group(int p) {
        return (parent[p] == p) ? p : group(parent[p]);
    }

    //O(log n)
    public void union(int a, int b) {
        int a_group = group(a);
        int b_group = group(b);

        if (size[a_group] > size[b_group]) {
            parent[b_group] = a_group;
            size[a_group] += size[b_group];
        } else {
            parent[a_group] = b_group;
            size[b_group] += size[a_group];
        }
    }
}