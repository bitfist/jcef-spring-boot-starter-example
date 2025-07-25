/** AUTO-GENERATED by JCEF TypeScriptObjectProcessor – DO NOT EDIT **/
import { CefCommunicationService } from '../../../../../../jcef/CefCommunicationService';
import type { CountResponse } from './CountResponse';
import type { CountRequest } from './CountRequest';

export class CounterService {
    public static simple(count: number): Promise<number> {
        return CefCommunicationService.request('io.github.bitfist.jcef.spring.example.CounterService', 'simple', {count}, 'number');
    }

    public static count(count: number, request: CountRequest): Promise<CountResponse> {
        return CefCommunicationService.request('io.github.bitfist.jcef.spring.example.CounterService', 'count', {count, request}, 'object');
    }

    public static random(): Promise<number> {
        return CefCommunicationService.request('io.github.bitfist.jcef.spring.example.CounterService', 'random', {}, 'number');
    }

}
