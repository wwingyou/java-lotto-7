package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        boolean[] check = new boolean[46];
        for (Integer number : numbers) {
            if (check[number])
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있으면 안됩니다.");
            check[number] = true;
        }
    }

    public int getPrize(List<Integer> winningNumbers, int bonus) {
        int matchCount = 0;
        boolean isBonusMatch = false;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number))
                matchCount += 1;
            if (bonus == number)
                isBonusMatch = true;
        }

        if (matchCount == 6) return 2_000_000_000;
        if (matchCount == 5 && isBonusMatch) return 30_000_000;
        if (matchCount == 5) return 1_500_000;
        if (matchCount == 4) return 50_000;
        if (matchCount == 3) return 5_000;
        return 0;
    }
}
