package baseball.model;

import baseball.common.GameRule;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int generate() {
        return Randoms.pickNumberInRange(GameRule.MIN_NUMBER.getValue(), GameRule.MAX_NUMBER.getValue());
    }
}
