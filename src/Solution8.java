import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Program to reverse elements of a sequential Stream in Java
class Solution8
{


	public static void main(String[] args)
	{
		List<Integer> lists = Arrays.asList(1, 4, 4, 3, 5, 7, 3, 5, 4);

//		int n = lists.size();
//		int[] i = {0};
//		List<Integer> left = lists.stream()
//				.filter(e->{
//					i[0] += 1;
//					if(i[0] < 6 )
//						return true;
//					return false;
//				})
//				.collect(Collectors.collectingAndThen(Collectors.toList(), list->{
//					Collections.reverse(list);
//					return list;
//				}));
//				
//			i[0] = 0;
//		List<Integer> right = lists.stream()
//				.filter(e->{
//					i[0] += 1;
//					if(i[0] > 6 )
//						return true;;;
//					return false;
//				})
//				.collect(Collectors.toList());
//			
				
//--------------------------------------------------------------------------------
		int[] idx = {0};
		

		
		//System.out.println(isEven);
				
				
				
//				.collect(Collector.of(ArrayList::new,
//				(list, element) -> {
//					list.add(element);
//					Collections.reverse(list);
//				},
//				(a, b) -> a));
				//.forEach(System.out::println);
		
//		System.out.println(left);
//		System.out.println(right);
		
	}
}