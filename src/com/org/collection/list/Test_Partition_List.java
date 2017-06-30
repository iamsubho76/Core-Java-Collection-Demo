package com.org.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Test_Partition_List {
	public static void main(String[] args) {
		Test_Partition_List.givenList_whenParitioningIntoSublistsUsingPartitionBy_thenCorrect();
		Test_Partition_List.givenList_whenParitioningIntoNSublistsUsingGroupingBy_thenCorrect();
	}
	
	public static void givenList_whenParitioningIntoSublistsUsingPartitionBy_thenCorrect() {

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		 
	    Map<Boolean, List<Integer>> groups = intList.stream().collect(Collectors.partitioningBy(s -> s > 6));
	    List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
	 
	    List<Integer> lastPartition = subSets.get(1);
	    List<Integer> expectedLastPartition = Arrays.asList(7, 8);
	    if(subSets.size() ==2)
	    	System.out.println("Array partitioned..");
	    if(lastPartition.size() == expectedLastPartition.size())
	    	System.out.println("Both partitioned are same size..");
	
	}
	
	public static final void givenList_whenParitioningIntoNSublistsUsingGroupingBy_thenCorrect() {
	    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
	 
	    Map<Integer, List<Integer>> groups = intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
	    List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
	 
	    List<Integer> lastPartition = subSets.get(2);
	    List<Integer> expectedLastPartition = Arrays.asList(7, 8);
	    if(subSets.size() ==2)
	    	System.out.println("Array partitioned in Group By..");
	    if(lastPartition.size() == expectedLastPartition.size())
	    	System.out.println("Both partitioned are same size in Group By..");
	}
	
	public void givenList_whenSplittingBySeparator_thenCorrect() {
	    List<Integer> intList = Arrays.asList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);
	 
	    int[] indexes = Stream.of(IntStream.of(-1), IntStream.range(0, intList.size())
	    					.filter(i -> intList.get(i) == 0), IntStream.of(intList.size()))
	    					.flatMapToInt(s -> s).toArray();
	    
	    List<List<Integer>> subSets = IntStream.range(0, indexes.length - 1)
	               						.mapToObj(i -> intList.subList(indexes[i] + 1, indexes[i + 1]))
	               						.collect(Collectors.toList());
	 
	    List<Integer> lastPartition = subSets.get(2);
	    List<Integer> expectedLastPartition = Arrays.asList(7, 8);
	    if(subSets.size() ==2)
	    	System.out.println("Array partitioned in Group By..");
	    if(lastPartition.size() == expectedLastPartition.size())
	    	System.out.println("Both partitioned are same size in Group By..");
	}
}
