import com.littlebuddha.housekeeping.common.other.AutoId;

/**
 * @author ck
 * @date 2020/7/27 13:52
 */
public class TestAutoId {
    public static void main(String[] args) {
        for (int i =0;i<20;i++) {
            String autoId = AutoId.getAutoId();
            System.out.println(autoId);
        }
    }
}
