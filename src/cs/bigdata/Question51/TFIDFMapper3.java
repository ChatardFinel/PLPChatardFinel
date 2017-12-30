package cs.bigdata.Question51;

import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.io.*;        
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.StringTokenizer;

// To complete according to your problem
public class TFIDFMapper3 extends Mapper<LongWritable,Text, Text, TripleMot> {
	
	private final static TripleMot tripleS = new TripleMot();
	private Text mot = new Text();
// Overriding of the map method
@Override
protected void map(LongWritable key, Text values, Context context) throws IOException,InterruptedException
    {
        // To complete according to the processing
        // Processing : keyI = ..., valI = ...
		String motETdoc = values.toString().split("\t")[0];
		String triple=values.toString().split("\t")[1];
		
		mot.set(motETdoc.split(";")[0]);
		tripleS.set(motETdoc.split(";")[1], Integer.parseInt(triple.split(";")[1]),Integer.parseInt(triple.split(";")[0]));
		context.write(mot, tripleS);
		
    }

public void run(Context context) throws IOException, InterruptedException {
    setup(context);
    while (context.nextKeyValue()) {
        map(context.getCurrentKey(), context.getCurrentValue(), context);
    }
    cleanup(context);
}

}