package patternComposite.folderFile;

public class Main {
	
	public static void main(String[] args) throws FileLeafException {
		// creo folder
		FolderComposite folder1 = new FolderComposite();
		FolderComposite folder2 = new FolderComposite();
		FolderComponent folder3 = new FolderComposite();
		FolderComponent folder4 = new FolderComposite();
		
		
		// creo file 
		FileLeaf file1 = new FileLeaf(20.2);
		FileLeaf file2 = new FileLeaf(22.2);
		FileLeaf file3 = new FileLeaf(10.2);
		FileLeaf file4 = new FileLeaf(42.1);
		FileLeaf file5 = new FileLeaf(13.1);
		FileLeaf file6 = new FileLeaf(20.2);
		
		// inserisco
		folder1.add(folder2);
		folder1.add(folder3);
		folder1.add(file1);
		
		folder2.add(folder4);
		
		folder3.add(file2);
		folder3.add(file3);
		
		folder4.add(file4);
		folder4.add(file5);
		folder4.add(file6);
		
		// errore funzionante !!
//		file1.add(file6);
		
		System.out.println(folder1.calcolaSpazio());
		
		
		
	}
	
	
}
