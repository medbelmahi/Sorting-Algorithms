class CountingSort {
    public static int[] sort(int[] T) {
        int[] count = new int[getMaxValue(T) + 1];

        for (int i = 0; i < T.length; i++) {
            count[T[i]] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        int[] sortedTable = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int number = T[i];
            int itsSortedPosition = count[number];
            sortedTable[itsSortedPosition-1] = number;
            count[number]--;
        }
        return sortedTable;
    }

    public static int getMaxValue(int[] numbers){
        int maxValue = numbers[0];
        for(int i=1;i < numbers.length;i++){
            if(numbers[i] > maxValue){
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }
}
