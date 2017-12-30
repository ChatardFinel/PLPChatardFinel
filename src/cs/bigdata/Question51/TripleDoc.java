package cs.bigdata.Question51;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


public class  TripleDoc implements WritableComparable <TripleDoc>{
	
	
	private IntWritable nbrMots;
	private IntWritable motsParDoc;
	private IntWritable docParMot;
	
	
	public TripleDoc() {
		this.nbrMots=new IntWritable();
		this.motsParDoc=new IntWritable();
		this.docParMot=new IntWritable();
		

	}

	public TripleDoc(IntWritable nbrMots,IntWritable motsParDoc,IntWritable docParMot) {
		this.motsParDoc=motsParDoc;
		this.nbrMots=nbrMots;
		this.docParMot=docParMot;

	}



	@Override
	public void readFields(DataInput input) throws IOException {
		motsParDoc.readFields(input);
		nbrMots.readFields(input);
		docParMot.readFields(input);
		
	}



	@Override
	public void write(DataOutput output) throws IOException {
		motsParDoc.write(output);
		nbrMots.write(output);
		docParMot.write(output);
	}



	@Override
	public int compareTo(TripleDoc o) {
		// TODO Auto-generated method stub
		if(nbrMots.compareTo(o.nbrMots)==0) {
			if(motsParDoc.compareTo(o.motsParDoc)==0) {
				return docParMot.compareTo(docParMot);
			}else {
				return motsParDoc.compareTo(o.motsParDoc);
			}
			
		}else {
			return nbrMots.compareTo(o.nbrMots);
		}
	}
	
	public void set(IntWritable nbrMots,IntWritable motsParDoc,IntWritable docParMot) {
		// TODO Auto-generated method stub
		this.nbrMots=nbrMots;
		this.motsParDoc=motsParDoc;
		this.docParMot=docParMot;
	}

	public void set(int nbrMots, int motsParDoc,int docParMot) {
		// TODO Auto-generated method stub
		this.nbrMots=new IntWritable(nbrMots);
		this.motsParDoc=new IntWritable(motsParDoc);
		this.docParMot=new IntWritable(docParMot);
	}

	public double getNbrMots() {
		// TODO Auto-generated method stub
		return (double)this.nbrMots.get();
	}
	
	public double getMotsParDoc() {
		// TODO Auto-generated method stub
		return (double)this.motsParDoc.get();
	}
	
	public double getDocParMot() {
		// TODO Auto-generated method stub
		return (double)this.docParMot.get();
	}

	public Text toText() {
		return new Text(nbrMots.toString()+";"+motsParDoc.toString()+";"+docParMot);
	}




	
}
	