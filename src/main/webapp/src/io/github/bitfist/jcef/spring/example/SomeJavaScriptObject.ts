/** AUTO-GENERATED by JCEF TypeScriptObjectProcessor – DO NOT EDIT **/
import { CefCommunicationService } from '../../../../../../jcef/CefCommunicationService';
import type { ComplexType2 } from './ComplexType2';
import type { ComplexType3 } from './ComplexType3';

export class SomeJavaScriptObject {
    public static something(id: number, name: string, aByte: number, type2: ComplexType2): Promise<ComplexType3> {
        return CefCommunicationService.request('io.github.bitfist.jcef.spring.example.SomeJavaScriptObject', 'something', {id, name, aByte, type2}, 'object');
    }

}
