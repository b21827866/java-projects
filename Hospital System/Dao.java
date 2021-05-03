import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dao {
	public static void reader(String a) {
		
		String str;
		String str1;
		ArrayList<String> line = new ArrayList<String>();
		ArrayList<String> line1 = new ArrayList<String>();
		
		try {
			FileInputStream fis = new FileInputStream(a);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			//error handling
			while((str = br.readLine()) != null ) {
				line.add(str);
				
			}
			dis.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		try {
			FileInputStream fis1 = new FileInputStream("patient.txt");
			DataInputStream dis1 = new DataInputStream(fis1);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(dis1));
			//error handling
			while((str1 = br1.readLine()) != null ) {
				line1.add(str1);
				
			}
			dis1.close();
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
		for(int i = 0; i<line.size(); i++) {
			String [] datas = line.get(i).split(" ");
			
			
			if(datas[0].equals("AddPatient")) {
				
				try {
		            FileWriter writer = new FileWriter("output.txt", true);
		            writer.write("Patient "+ datas[1]+ " " +datas[2] + " added" + "\n");
		            writer.close();

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				line1.add(datas[1]+ "\t" +datas[2]+ " " +datas[3]+"\t" + datas[4] +"\t"+ "Address:" + line.get(i).split(datas[4])[1]);
				
				/*
				try {
		            FileWriter writer1 = new FileWriter("patient.txt", true);
		            writer1.write("\n");
		            writer1.write(datas[1]+ "\t" +datas[2]+ " " +datas[3]+"\t" + datas[4] +"\t"+ "Address:" + line.get(i).split(datas[4])[1]);
		            writer1.close();

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				*/	
				
			}
			
			if(datas[0].equals("RemovePatient")) {
				
				for(int j = 0; j<line1.size(); j++) {
					String [] datas1 = line1.get(j).split("\t");
					if(datas1[0].equals(datas[1])) {
						try {
				            FileWriter writer1 = new FileWriter("output.txt", true);
				            writer1.write("Patient "+ datas[1] + " " +datas1[1].split(" ")[0] + " removed" + "\n");
				            writer1.close();

				        } catch (IOException e) {
				            e.printStackTrace();
				        }
					}
					if(datas1[0].equals(datas[1])) {
						line1.remove(j);
					}
					
				}
				

				
			}
			if(datas[0].equals("CreateAdmission")) {
				try {
	            FileWriter writer = new FileWriter("output.txt", true);
	            writer.write("Admission "+ datas[1] + " created" + "\n");
	            writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(datas[0].equals("AddExamination")) {
				try {
	            FileWriter writer = new FileWriter("output.txt", true);
	            writer.write(datas[2] + " examination added to admission "+ datas[1] + "\n");
	            writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
		
			}
			if(datas[0].equals("TotalCost")) {
				try {
		            FileWriter writer = new FileWriter("output.txt", true);
		            writer.write("TotalCost for admission "+ datas[1] + "\n");
		            writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(datas[0].equals("ListPatients")) {
				Collections.sort(line1, (s1, s2) -> {
				    String sb1 = s1.split("\t")[1];
				    String sb2 = s2.split("\t")[1];
				    return sb1.compareTo(sb2);
				    });
				
				
				try {
		            FileWriter writer = new FileWriter("output.txt", true);
		            writer.write("Patient List:"+ "\n");
		            writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				for(int k = 0; k<line1.size(); k++) {
					try {
			            FileWriter writer = new FileWriter("output.txt", true);
			            
			            writer.write(line1.get(k) + "\n");
			            writer.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
				}
				
			}
			
		}
		PrintWriter writer;
		try {
			writer = new PrintWriter("patient.txt");
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		/*
		Collections.sort(line1, (s1, s2) -> {
		    String sb1 = s1.split("\t")[0];
		    String sb2 = s2.split("\t")[0];
		    return sb1.compareTo(sb2);
		    });
		*/
		Comparator<? super String> myComparator = new Comparator<String>() {
	
	    public int compare(String name1, String name2) {
	        int num1 = Integer.parseInt(name1.split("\t")[0]);
	        int num2 = Integer.parseInt(name2.split("\t")[0]);
	        // > : Increasing order 
	        // < : Decreasing order
	        if(num1 > num2)
	        	return 1;
	        else
	        	return -1;
	      }

        };
        Collections.sort(line1, myComparator);
        
		
		
		for(int i = 0; i<line1.size(); i++) {
			try {
	            FileWriter writer1 = new FileWriter("patient.txt", true);
	            
	            writer1.write(line1.get(i) + "\n");
	            writer1.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//IExamination ex = new test(new imaging(new Outpatient()));
		//System.out.println(ex.getCost());
		//System.out.println(ex.getDescription());
	}

}
