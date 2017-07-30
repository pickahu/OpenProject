package pickahu.openproject.retrofit2;

import java.util.List;

/**
 * Created by huyunpeng on 2017/7/26.
 */

public class Info {

    @Override
    public String toString() {
        return "Info{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public int error_code;
    public String reason;
    public ResultBean result;

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "data=" + data +
                    '}';
        }

        public List<DataBean> data;

        public static class DataBean {
            public String content;
            public String hashId;
            public int unixtime;
            public String updatetime;

            @Override
            public String toString() {
                return "DataBean{" +
                        "content='" + content + '\'' +
                        ", hashId='" + hashId + '\'' +
                        ", unixtime=" + unixtime +
                        ", updatetime='" + updatetime + '\'' +
                        '}';
            }
        }
    }
}
