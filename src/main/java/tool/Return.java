package tool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.log4j.Logger;


/**
 * Created by zhangyan1 on 17/3/02.
 */

public class Return extends HashMap<String, Object> {
    private static final long serialVersionUID = 2203513787220720192L;
    private static final Logger LOGGER = Logger.getLogger(Return.class.getName());

    public enum Return_Fields {
      success, code, note
    }

    //////////////////////////////// create//////////////////////////////////
    public static Return create() {
      return new Return();
    }

    public static Return create(String key, Object value) {
      return new Return().add(key, value);
    }

    public static Return create(String json) {
      Return jo = new Return();
      try {
        Map<String, Object> fromJson = JsonConvert.toObject(json, new TypeReference<HashMap<String, Object>>() {
        });
        for (Entry<String, Object> entry : fromJson.entrySet()) {
          jo.put(entry.getKey(), entry.getValue());
        }
      } catch (IOException e) {
        LOGGER.error("Return.create 解析 JSON 失败", e);
        return Return.FAIL(Code.GENERATER_RETURN_ERROR);
      }
      return jo;
    }

    /////////////////////////////////////////// SUCCESS/////////////////////////

    public static Return SUCCESS(Integer code, String note) {
      Return jo = new Return();
      jo.put(Return_Fields.success.name(), true);
      jo.put(Return_Fields.code.name(), code);
      jo.put(Return_Fields.note.name(), note);
      return jo;
    }

    public static Return SUCCESS(String json) {
      Return jo = create(json);
      jo.put(Return_Fields.success.name(), true);
      return jo;
    }

    public static Return SUCCESS(Code code) {
      return SUCCESS(code.code, code.note);
    }

    ///////////////////////////////////////////////// FAIL////////////////////////////
    public static Return FAIL(Integer code, String note) {
      Return jo = new Return();
      jo.put(Return_Fields.success.name(), false);
      jo.put(Return_Fields.code.name(), code);
      jo.put(Return_Fields.note.name(), note);
      return jo;
    }

    public static Return FAIL(Code code) {
      return FAIL(code.code, code.note);
    }

    public static Return FAIL(Code code, Exception e) {
      return FAIL(code.code, Utils.stacktrace(e));
    }

    //////////////////////////////////// GETTER SETTER///////////////////////////
    public Boolean is_success() {
      return (Boolean) this.getOrDefault(Return_Fields.success.name(), false);
    }

    public Integer get_code() {
      return (Integer) this.getOrDefault(Return_Fields.code.name(), Code.ERROR.code);
    }

    public String get_note() {
      return (String) this.getOrDefault(Return_Fields.note.name(), "");
    }

    //////////////////////// @Override/////////////////////////////////////
    @Override
    public Return put(String key, Object value) {
      super.put(key, value);
      return this;
    }

    public Return add(String key, Object value) {
      super.put(key, value);
      return this;
    }

    public String toJson() {
      try {
        return JsonConvert.toJson(this);
      } catch (Exception e) {
        LOGGER.error("json 解析失败:", e);
        return JsonConvert.toJson(Return.FAIL(Code.GENERATER_RETURN_ERROR));
      }
    }
}
