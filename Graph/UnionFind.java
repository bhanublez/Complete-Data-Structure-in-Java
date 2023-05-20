public class UnionFind{
    private int size;
    private int[] sz;
    private int[] id;
    private int numComponents;
    public UnionFind(int size){
        if(size<=0){
            throw new IllegalArgumentException("Size <= 0is not allowed");
        }
        this.size=numComponents=size;
        sz=new int[size];
        id= new int[size];
        for(int i=0;i<size;i++){
            id[i]=i;//Linked to itself(self loop)
            sz[i]=1;//Eac component is originally of size of one
        }
    }

    //Find which coponent/set p belogs to, takes amortized constant time
    public int find(int p){
        //Finding the root of the component/set
        int root =p;
        while(root!= id[root])
        //Compress the path leading back to the root
        //Doing this operation is called path compression
        //and is what gives us amoritized constant time complexity
            root=id[root];
            while(p!=root){
                int next=id[p];
                id[p]=root;
                p=next;         
        }
        return root;  
    }

    //REturn whether r not the elements p and q
    //q are in the same components/set.
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    //Return the size of the components/set p belongs to
    public int componentSize(int p){
        return sz[find(p)];
    }

    //Return the number of elements in this UnionField/Disjoint set
    public int size(){
        return size;
    }

    //Return the number of remaining componenets/sets
    public int components(){
        return numComponents;
    }

    //Unify the components/sets containing elements p and p;
    public void unify(int p,int q){
        int root1=find(p);
        int root2=find(q);

        //These elements are already in the same group
        if(root1==root2) return;

        //Merge two componts/sets together
        //Merge smaller components set into the larger one
        if(sz[root1]<sz[root2]){
            sz[root2]+=sz[root1];
            id[root1]=root2;
        }
        else{
            sz[root1]+=sz[root2];
            id[root2]=root1;
        }

        //Since the rooot s found are different we know that the number of component/sets 
        //has decreased by one
        numComponents--;
    }
    
} 