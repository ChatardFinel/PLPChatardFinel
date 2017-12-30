package cs.bigdata.Question51;

import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class TFIDFReducer3 extends Reducer<Text, TripleMot, Text, Text> {

	//initialisation des variables
	private MotDoc motETdoc=new MotDoc();
	private TripleDoc tripleS = new TripleDoc();
	private double tfidf;
	private double nbrDocs=2;
	private Text txt=new Text();

	@Override
	public void reduce(final Text key, final Iterable<TripleMot> values,
			final Context context) throws IOException, InterruptedException {

		IntWritable docParMot=new IntWritable();
		int sum = 0;
		Iterator<TripleMot> listeTriple = values.iterator();

		while (listeTriple.hasNext()) {
			TripleMot triple=listeTriple.next();
			sum +=1;
			motETdoc.set(key,triple.getDocID());
			
			if (listeTriple.hasNext() && sum==1 || sum==2) {
				docParMot.set(2);
			}
			
			else {
				docParMot.set(1);
			}
			
			tripleS.set(triple.getMotsParDoc(),triple.getNbrMots(), docParMot);
			double terme1=tripleS.getNbrMots()/tripleS.getMotsParDoc();
			double terme2=Math.log10(nbrDocs/tripleS.getDocParMot());
			tfidf=terme1*terme2;
			
			
			txt.set(String.valueOf(tfidf));
			//on renvoie la sortie clé:(mot,doc) valeur:tfidf
			context.write(motETdoc.toText(), txt);
		}




	}
}