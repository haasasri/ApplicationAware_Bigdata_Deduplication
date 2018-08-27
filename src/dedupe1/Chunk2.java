package dedupe1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;
import java.util.Arrays;

/**
 * Perform a fixed size de-duplication. Print out de-duplication results if
 * there is duplicated data chunks
 *
 * @author rajaneesh
 *
 */
public class Chunk2 {
	public Hashtable<String, String> indexTable;
	public Hashtable<String, String> indexTable1;
	public Hashtable<String, String> indexTable2;
	public Checksum sum;
	public FileList list;
	public int count;
	public int count1;
	public int i,listi;
	public int lcount1;
	public int lcount2;
	public int lcount3;
	private FileInputStream fis;
	String[] sa1 =	new String[100];
	public Chunk2(String directory) {
		System.out.println("entered");
		indexTable = new Hashtable<String,String>();
		indexTable1 = new Hashtable<String, String>();
		indexTable2 = new Hashtable<String, String>();
		sum = new Checksum();
		// list = new FileList(Config.DIRECTORY);
		list = new FileList(directory);
		count = 0;
	}
	
	public void setAll(File f) {
		// Read each file and perform fixed-size chunking
		byte[] chunk = new byte[Config.FIXED_CHUNKING];
		/*for (File f : fileList)
		{
			//System.out.println(getFileExtension(f));
			count = 0;
			if (f.isFile() && !f.isHidden()) {
				// Read file into a byte array and use SHA-1 hash the chunk
				try {
					fis = new FileInputStream(f.getAbsolutePath());
					while (fis.read(chunk) != -1) {
						// perform the hash on the chunk
						count++;
						System.out.println(count);
						String hashvalue = sum.chunking(chunk);
						// If not exist then save
						if (!indexTable.containsKey(hashvalue)) {
							indexTable.put(hashvalue, f.getName());
						} else {
							System.out.println(++count
									+ " duplicate contents found in: "
									+ f.getName());
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		//for (File f : fileList)
				
					//System.out.println(getFileExtension(f));
					count = 0;
					count1=0;
					if (f.isFile() && !f.isHidden()) {
						// Read file into a byte array and use SHA-1 hash the chunk
						try {
							fis = new FileInputStream(f.getAbsolutePath());
							while (fis.read(chunk) != -1) {
								// perform the hash on the chunk
								//count++;
								//count1++;
								//System.out.println("count");
								//System.out.println(count);
								String hashvalue = sum.chunking(chunk);
								sa1[count1]=hashvalue;
								count1++;
								
								if(count1==10) 
								{
									lcount1=0;lcount2=0;lcount3=0;
									for(i=0;i<5;i++)
									{
										hashvalue=sa1[i];
									if (indexTable.containsKey(hashvalue)) {
										lcount1++;
									}
									else if (indexTable1.containsKey(hashvalue)) {
										lcount2++;
									}
									else if (indexTable2.containsKey(hashvalue)) {
										lcount3++;
									}
									}
									int max= Math.max(Math.max(lcount1, lcount2),lcount3);
									//int listi;
									if(max==lcount1) {listi=1;}
									else if(max==lcount2) {listi=2;}
									else if(max==lcount3) {listi=3;}
									if(max!=0)
									{
										if(listi==1)
										{
											System.out.println("node1");
											for(i=0;i<count1;i++)
											{
												hashvalue=sa1[i];
										if (!indexTable.containsKey(hashvalue)) {
											indexTable.put(hashvalue, f.getName());
										} else {
											System.out.println(
									                 " duplicate contents found in: "
													+ f.getName());
										}}}
										else if(listi==2)
										{
											System.out.println("node2");
											for(i=0;i<count1;i++)
											{
												hashvalue=sa1[i];
										if (!indexTable1.containsKey(hashvalue)) {
											indexTable1.put(hashvalue, f.getName());
										} else {
											System.out.println(
													" duplicate contents found in: "
													+ f.getName());
										}}}
										else if(listi==3)
										{
											System.out.println("node3");
											for(i=0;i<count1;i++)
											{
												hashvalue=sa1[i];
										if (!indexTable2.containsKey(hashvalue)) {
											indexTable2.put(hashvalue, f.getName());
										} else {
											System.out.println(
													" duplicate contents found in: "
													+ f.getName());
										}}}
										}
									else
									{
										Random rand = new Random(); 
										int value = rand.nextInt(3)+1;
										if(value==1)
										{										
											indexTable.put(hashvalue, f.getName());
										}
										else if(value==2)
										{
											indexTable1.put(hashvalue, f.getName());
										}
										else if(value==3)
										{
											indexTable2.put(hashvalue, f.getName());
										}
									}
									count1=0;
									}
									
									}
							   if(count1<10)
							   {
								   System.out.println("less count:");
								   System.out.println(count1);
								   for(int i=0;i<count1;i++)
								   {
									   String hashvalue =sa1[i];  
								   if (!indexTable.containsKey(hashvalue)) {
										indexTable.put(hashvalue, f.getName());
									} else {
										System.out.println(
												" duplicate contents found in: "
												+ f.getName());
									}
								   }
							   }
							
								}
								// If not exist then save								
							
						catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
				
	}

}
}