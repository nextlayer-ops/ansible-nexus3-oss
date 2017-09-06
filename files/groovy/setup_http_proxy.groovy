import groovy.json.JsonSlurper

parsed_args = new JsonSlurper().parseText(args)


core.removeHTTPProxy()
if (parsed_args.with_http_proxy) {
    if (parsed_args.http_proxy_username) {
        core.httpProxyWithBasicAuth(parsed_args.http_proxy_host, parsed_args.http_proxy_port, parsed_args.http_proxy_username, parsed_args.http_proxy_password)
    } else {
        core.httpProxy(parsed_args.http_proxy_host, parsed_args.http_proxy_port)
    }
}

core.removeHTTPSProxy()
if (parsed_args.with_https_proxy) {
    if (parsed_args.https_proxy_username) {
        core.httpsProxyWithBasicAuth(parsed_args.https_proxy_host, parsed_args.https_proxy_port, parsed_args.http_proxy_username, parsed_args.https_proxy_password)
    } else {
        core.httpsProxy(parsed_args.https_proxy_host, parsed_args.https_proxy_port)
    }
}
