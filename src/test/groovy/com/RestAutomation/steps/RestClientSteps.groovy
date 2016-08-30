import groovy.transform.Field
import org.junit.Assert


/**
 * Created by mohmedyusoof.as on 5/27/2016.
 */
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


//@Field
//RestClient restClient = new RestClient(ConfigurationHelper.getProperties().get("baseUrl"))


@Field
RestClient restClient = ConfigurationHelper.getRestInstance()

def response

Given(~'I hit the get country service'){->
    response = restClient.get(path: "posts")
    Assert.assertEquals(response.responseData.find{it.id == 1}.title,"nt aut facere repellat provident occaecati excepturi optio reprehenderit")
    assert response.responseBase.statusline.statusCode, 200
}

Given(~"I git the get call with query param"){->
    response = restClient.get(path:"posts", query:["userId": 1])
    assert response.responseData.size , 10
    response.responseData.each {it -> println it.title}
}

Given(~'I perform the post call'){->
    def includeBody = [
        "userId": 11,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    ]
    response = restClient.post(path: "posts", body:includeBody)
    assert response.responseBase.statusline.statusCode, 201
}
Given(~/^I perform simple call with (.*)$/) { inputParameter ->
    println inputParameter
    println inputParameter
}