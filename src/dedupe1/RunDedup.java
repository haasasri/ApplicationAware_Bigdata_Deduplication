package dedupe1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public class RunDedup {

	/**
	 * Main function: Require user input type of chunking and the directory
	 *
	 * @author rajaneesh
	 *
	 */
	
		public Hashtable<String, String> indexTable;
		public Checksum sum;
		
		//private FileInputStream fis;

		private static String getFileExtension(File file) {
		    String name = file.getName();
		    try {
		        return name.substring(name.lastIndexOf(".") + 1);
		    } catch (Exception e) {
		        return "";
		    }
		}

		

		public static void main(String[] args) {
		int length = args.length;
		FixedSizeChunking fix = null;
		Chunk2 fix2=null;
		Chunk3 fix3=null;
		FileBasedChunking file = null;
		RabinKarpRollingHash rabin = null;
		System.out.println("entered");
		 FileList list;
		//int count;
		list = new FileList(args[1]);
		//list.getFile(2);
		System.out.println("done");
		String pdfy="pdf";
		String jpgy="JPG";
		String zipy="zip";
		String namer= new String();
		//count = 0;
		
		/*try {
			if (length == 0) {
				throw new RuntimeException("Keyword is needed.");
			} 
			 else if (length == 2) {
				switch (Integer.parseInt(args[0])) {
				case 1:
					fix = new FixedSizeChunking(args[1]);
					fix.setAll(fix.list.filelist);
					break;
				case 2:
					file = new FileBasedChunking(args[1]);
					file.setAll(file.list.filelist);
					break;
				case 3:
					rabin = new RabinKarpRollingHash(args[1]);
					rabin.setAll(rabin.list.filelist);
					break;
				default:
					throw new RuntimeException(
							"Please enter 1 : Fixed size chunking; 2 : File based chunking; 3 : Content defined chunking");
				}
			} else {
				throw new RuntimeException(
						"Too many parameters, only chunking type and directory are needed.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("finished deduplication");
	}*/
		try {
			if (length == 0) {
				throw new RuntimeException("Keyword is needed.");
			} 
			 else if (length == 2) {
				 fix = new FixedSizeChunking(args[1]);
				 fix2 = new Chunk2(args[1]);
				 fix3 = new Chunk3(args[1]);
				 //file = new FileBasedChunking(args[1]);
				 //rabin = new RabinKarpRollingHash(args[1]);
				 for (File f : list.filelist)
					{
						if (f.isFile() && !f.isHidden())
						{
							
							namer =getFileExtension(f);
							System.out.println(namer);
						}
					
				if(namer.equals(pdfy))
				{
					System.out.println("fixed size");
					
					fix.setAll(f);
				}
				else if(namer.equals(jpgy))
				{
					System.out.println("file based");
					
					fix2.setAll(f);
				}
				else if(namer.equals(zipy))
				{
                      System.out.println("rabin karp");
					
					fix3.setAll(f);
				}
			}} else {
				throw new RuntimeException(
						"Too many parameters, only chunking type and directory are needed.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("finished deduplication");
	}

}