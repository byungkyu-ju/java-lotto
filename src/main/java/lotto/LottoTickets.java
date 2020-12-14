package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
public class LottoTickets {
	private static final int LOTTO_TICKET_PRICE = 1000;
	private static final int MINIMUM_OF_AUTO_CREATE_NUMBER = 1;
	private static final int MAXIMUM_OF_AUTO_CREATE_NUMBER = 46;

	private List<LottoTicket> lottoTickets;

	public LottoTickets(int cash) {
		lottoTickets = new ArrayList<>();
		lottoTickets = createTickets(cash);
	}

	private List<LottoTicket> createTickets(int cash) {
		int ticketCount = cash / LOTTO_TICKET_PRICE;
		for (int i = 0; i < ticketCount; i++) {
			lottoTickets.add(generateRandomTicket());
		}
		return lottoTickets;
	}

	private LottoTicket generateRandomTicket() {
		List<Integer> shuffledNumber = new ArrayList<>();
		for (int i = MINIMUM_OF_AUTO_CREATE_NUMBER; i <= MAXIMUM_OF_AUTO_CREATE_NUMBER; i++) {
			shuffledNumber.add(i);
		}
		Collections.shuffle(shuffledNumber);
		shuffledNumber = shuffledNumber.subList(0, 6);
		return generateLottoNumber(shuffledNumber);
	}

	private LottoTicket generateLottoNumber(List<Integer> shuffledNumber) {
		List<LottoNumber> lottoNumbers = shuffledNumber.stream().map(LottoNumber::new).collect(Collectors.toList());
		return new LottoTicket(lottoNumbers);
	}

	public int getTicketCount() {
		return lottoTickets.size();
	}
}