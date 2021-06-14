package kodlama.io.hrms.core.utilities.helpers;

import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import lombok.var;

public class BusinessRule {
	public static Result run(Result... results){
        for (var result:results) {
            if(!result.isSuccess()){
                return result;
            }
        }
        return new SuccesResult();
    }
}