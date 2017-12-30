package cs.bigdata.Question51;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


public class  TripleMot implements WritableComparable <TripleMot>{

	private Text docID;
	private IntWritable nbrMots;
	private IntWritable motsParDoc;
	
	//constructeur
	public TripleMot() {
		this.docID=new Text();
		this.motsParDoc=new IntWritable();
		this.nbrMots=new IntWritable();

	}

	public TripleMot(Text docID,IntWritable nbrMots,IntWritable motsParDoc) {
		this.docID=docID;
		this.motsParDoc=motsParDoc;
		this.nbrMots=nbrMots;

	}

	//methode necessaire au MapReduce


	@Override
	public void readFields(DataInput input) throws IOException {
		docID.readFields(input);
		motsParDoc.readFields(input);
		nbrMots.readFields(input);
		
	}

	@Override
	public void write(DataOutput output) throws IOException {
		docID.write(output);
		motsParDoc.write(output);
		nbrMots.write(output);
	}

	@Override
	public int compareTo(TripleMot o) {
		return 0;

	}
	
	//set et get

	public void set(String doc,int nbrMots, int motsParDoc) {
		// TODO Auto-generated method stub
		this.docID=new Text(doc);
		this.nbrMots=new IntWritable(nbrMots);
		this.motsParDoc=new IntWritable(motsParDoc);
	}

	
	public Text getDocID() {
		return docID;
	}
	
	public IntWritable getNbrMots() {
		return this.nbrMots;
	}
	
	public IntWritable getMotsParDoc() {
		return this.motsParDoc;
	}


	
}
	