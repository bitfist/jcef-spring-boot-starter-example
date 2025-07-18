/** AUTO-GENERATED by JCEF TypeScriptObjectProcessor – DO NOT EDIT **/
import { CefQueryService } from './CefQueryService';
import type { CountRequest } from '../io/github/bitfist/jcef/spring/example/CountRequest';
import type { CountResponse } from '../io/github/bitfist/jcef/spring/example/CountResponse';

export class CounterService {
    public static simple(count: number): Promise<number> {
        return CefQueryService.request('io.github.bitfist.jcef.spring.example.CounterService', 'simple', {count}, 'number');
    }

    public static count(count: number, request: CountRequest): Promise<CountResponse> {
        return CefQueryService.request('io.github.bitfist.jcef.spring.example.CounterService', 'count', {count, request}, 'object');
    }

    public static random(): Promise<number> {
        return CefQueryService.request('io.github.bitfist.jcef.spring.example.CounterService', 'random', {}, 'number');
    }

}
