import com.littlebuddha.housekeeping.common.other.AutoId;
import com.littlebuddha.housekeeping.entity.system.Menu;
import org.junit.Test;

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

    @Test
    public void ft(){
        Menu menu = new Menu();
        System.out.println(Menu.DEL_FLAG_NORMAL);
    }
}
