package cs.bigdata.Question53a;


import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;


public class TreeTypeReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	private IntWritable totalTypeCount = new IntWritable();

	@Override
	public void reduce(final Text key, final Iterable<IntWritable> values,
	    final Context context) throws IOException, InterruptedException {

	        int sum = 0;
	        Iterator<IntWritable> iterator = values.iterator();

	        while (iterator.hasNext()) {
	            sum += iterator.next().get();
	        }

	        totalTypeCount.set(sum);
	        // context.write(key, new IntWritable(sum));
	        context.write(key, totalTypeCount);
	}
}
