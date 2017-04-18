package com.ruijc.task;

//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

import com.ruijc.IdObject;

import java.util.Calendar;

/**
 * 抽象任务
 *
 * @author Storezhang
 * @create 2017-04-12 12:58
 * @email storezhang@gmail.com
 * @qq 160290688
 */
public abstract class AbstractTask extends IdObject implements IRingTask {

    private int cycle;//圈数
    private int index;//槽位

    public AbstractTask(long id, int after) {
        super(id);

        Calendar calendar = Calendar.getInstance();
        int second = calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.SECOND);
        this.index = (second + after) % 3600;
        this.cycle = after / 3600;
    }

    public void after(int after) {
        Calendar calendar = Calendar.getInstance();
        int second = calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.SECOND);
        this.index = (second + after) % 3600;
        this.cycle = after / 3600;
    }

    public int getCycle() {
        return this.cycle;
    }

    public void countDown() {
        this.cycle -= 1;
    }

    public int getIndex() {
        return index;
    }
}